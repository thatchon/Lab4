package com.example.lab4;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;

@Route(value = "index2")
public class CashierView extends VerticalLayout {
    private TextField change, thousands, fiveHundreds, hundreds, twenties, tens, fives, ones;
    private Button calculate;

    public CashierView(){
        change = new TextField("เงินทอน");
        thousands = new TextField();
        fiveHundreds = new TextField();
        hundreds = new TextField();
        twenties = new TextField();
        tens = new TextField();
        fives = new TextField();
        ones = new TextField();
        calculate = new Button("คำนวณเงินทอน");

        change.setPrefixComponent(new Span("$"));
        thousands.setPrefixComponent(new Span("$1000:"));
        fiveHundreds.setPrefixComponent(new Span("$500:"));
        hundreds.setPrefixComponent(new Span("$100:"));
        twenties.setPrefixComponent(new Span("$20:"));
        tens.setPrefixComponent(new Span("$10:"));
        fives.setPrefixComponent(new Span("$5:"));
        ones.setPrefixComponent(new Span("$1:"));

        this.add(change, calculate, thousands, fiveHundreds, hundreds, twenties, tens, fives, ones);

        calculate.addClickListener(buttonClickEvent -> {
            int amount = Integer.parseInt(change.getValue());

            Change out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/getChange/"+amount)
                    .retrieve()
                    .bodyToMono(Change.class)
                    .block();

            thousands.setValue(String.valueOf(out.getB1000()));
            fiveHundreds.setValue(String.valueOf(out.getB500()));
            hundreds.setValue(String.valueOf(out.getB100()));
            twenties.setValue(String.valueOf(out.getB20()));
            tens.setValue(String.valueOf(out.getB10()));
            fives.setValue(String.valueOf(out.getB5()));
            ones.setValue(String.valueOf(out.getB1()));
        });
    }
}