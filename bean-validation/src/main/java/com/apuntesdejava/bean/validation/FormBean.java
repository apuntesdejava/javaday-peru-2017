/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apuntesdejava.bean.validation;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author diego
 */
@Named(value = "formBean")
@RequestScoped
public class FormBean {

    private Empleado empleado = new Empleado();

    /**
     * Creates a new instance of FormBean
     */
    public FormBean() {
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

}
