package com.example.recycle_view;

import java.util.ArrayList;

//se crea la clase repositorio para separar el codigo respecto a la parte del almacenamiento de los datos
public class Repository {
    static ArrayList<Model> models = new ArrayList<Model>(); //Arreglo que contiene la información
    public static void Add(Model model) { //Metodo para agregar datos al arreglo
        models.add(model);
    }
    public static ArrayList<Model> List() { //Para retornar el arreglo con los datos para poder usarlo en el RecyclerView
        return models;
    }
    public static void ClearAll() { //Para evitar que se repita los datos al salir de la app
        models.removeAll(models);
    }
}