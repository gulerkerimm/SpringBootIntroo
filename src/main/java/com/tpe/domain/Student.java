package com.tpe.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter//tüm fieldlar için getter metodunun tanımlanmasını sağlar
@Setter//tüm fieldlar için setter metodunun tanımlanmasını sağlar
@AllArgsConstructor//tüm fieldların parametrede verildiği cont. metodunu tanımlar
@NoArgsConstructor//default const. metodunu tanımlar

//@RequiredArgsConstructor
//objeyi const ederken final olan zorunlu olan değerleri vereceğiz
//public Student(String name, String lastname) {
//        this.name = name;
//        this.lastname = lastname;
//        }

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotBlank(message = "name can not be blank!")
    @Size(min = 2,max = 50,message = "name must be between 2 and 50")
    @Column(nullable = false,length = 50)
    /*final*/ private String name;

    @NotBlank(message = "lastname can not be blank!")
    @Size(min = 2,max = 50,message = "lastname must be between 2 and 50")
    @Column(nullable = false)
    /*final*/ private String lastname;

    @NotNull(message = "please provide grade!")
    @Column(nullable = false)
    private Integer grade;

    @Email(message = "please provide valid email!")//aaa@bbb.ccc email formatında olmasını doğrulama
    //@Pattern():regex ile format belirlenebilir
    @Column(nullable = false,unique = true)
    private String email;

    @Setter(AccessLevel.NONE)
    private LocalDateTime createDate=LocalDateTime.now();

    //getter-setter

    @OneToMany(mappedBy = "student")
    private List<Book> bookList=new ArrayList<>();

}