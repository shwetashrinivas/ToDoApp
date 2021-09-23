package com.shwetashrinivas.todo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoPO {

    @Id
    private int todoId;
    
    private String todoTitle;
    private String todoContent;
    private String todoStatus;
    private Date todoCreationDate;

}
