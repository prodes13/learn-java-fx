package com.prodes13.todolist;

import com.prodes13.todolist.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<TodoItem> todoItems;

    @FXML
    private ListView<TodoItem> todoListView;

    @FXML
    private TextArea itemDetailsTextArea;

    public void initialize() {
        TodoItem item1 = new TodoItem("Mai birthday card", "Buy a birthday card!", LocalDate.of(2018, Month.APRIL, 25));
        TodoItem item2 = new TodoItem("Item2", "This is text for item 2!", LocalDate.of(2018, Month.APRIL, 16));
        TodoItem item3 = new TodoItem("Item3", "This is text for item 3!", LocalDate.of(2020, Month.DECEMBER, 5));
        TodoItem item4 = new TodoItem("Item4", "This is text for item 4!", LocalDate.of(2020, Month.OCTOBER, 20));
        TodoItem item5 = new TodoItem("Item5", "This is text for item 5!", LocalDate.of(2020, Month.NOVEMBER, 12));

        todoItems = new ArrayList<TodoItem>();
        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);
        todoItems.add(item4);
        todoItems.add(item5);

        todoListView.getItems().setAll(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    @FXML
    public void handleClickListView() {
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
        System.out.println(item);
//        itemDetailsTextArea.setText(item.getDetails());
        StringBuilder sb = new StringBuilder(item.getDetails());
        sb.append("\n\n\n\n");
        sb.append("Due: ");
        sb.append(item.getDeadLine().toString());
        itemDetailsTextArea.setText(sb.toString());
    }
}
