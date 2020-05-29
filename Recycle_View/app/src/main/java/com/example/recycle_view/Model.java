package com.example.recycle_view;

public class Model {
    private String title;
    private String description;
    private int img;
    private String NmbProfesor;
    private String dia;
    private String fechaEntrega;
    private String hora;

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNmbProfesor() {
        return NmbProfesor;
    }

    public void setNmbProfesor(String nmbProfesor) {
        NmbProfesor = nmbProfesor;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public int getImg(){
        return img;
    }
    public void setImg(int img){
        this.img = img;
    }
}
