package com.apuntesdejava.jsonb.demo;

import java.util.Date;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbNumberFormat;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;

/**
 *
 * @author diego
 */
public class Libro {

    @JsonbTransient
    private String nombre;
    private int anio;
    private String isbn;
    @JsonbDateFormat(value = "dd/MM/yyyy")
    private Date fechaPublicacion;

    @JsonbProperty(value = "valor")
    @JsonbNumberFormat(value = "#,##0.00000", locale = "en_US")
    private Double precio;

    private String codInterno;

    public String getCodInterno() {
        return codInterno;
    }

    public void setCodInterno(String codInterno) {
        this.codInterno = codInterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Libro{" + "nombre=" + nombre + ", anio=" + anio + ", isbn=" + isbn + ", fechaPublicacion=" + fechaPublicacion + '}';
    }

}
