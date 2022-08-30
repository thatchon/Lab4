package com.example.lab4;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;


@Route(value = "index")
public class MathView extends VerticalLayout {
    private TextField tn1, tn2, ans;
    private Button test;
}
