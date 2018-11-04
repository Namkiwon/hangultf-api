package com.skuniv.hangultfapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="word",uniqueConstraints=@UniqueConstraint(columnNames={"name","category"}))
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idx")
    private Long idx;

    @Column(name="name")
    private String name;

    @Column(name="category")
    private String category;

    public Word(String name, String category){
        this.name = name;
        this.category = category;
    }

}
