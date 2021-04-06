package com.example.PlanetsAndLords.Domain;

import net.bytebuddy.asm.Advice;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class Lord {
    private int id;
    /*@NotBlank(message="Пожалуйста, введите имя Повелителя")*/
    private String name;
    /*@NotBlank(message="Пожалуйста, введите возраст Повелителя")
    @Length(max=9,message = "Слишком большой возраст Повелителя, столько невозможно прожить")*/
    private int age;
    public Lord(){}
    public Lord(String name, int age){
        this.name = name;
        this.age = age;
    }
    public Lord(String name, int age, int id){
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
