package com.nlobo.testingdemo.controllers;

import com.nlobo.testingdemo.services.TodoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TodoController.class)
public class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoService todoService;

    @Test
    public void testTodosPage() throws Exception {
        // Arrange

        // Act
        mockMvc.perform(get("/todos"))
                // Assert
                .andExpect(status().isOk())
                .andExpect(view().name("all-todos.jsp"));
    }

    @Test
    public void testCreateTodo() throws Exception {
        // Arrange
        String task = "Example task";

        // Act
        mockMvc.perform(post("/todos/create")
                        .param("task", task))
                // Assert
                .andExpect(status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/todos"));
    }

    @Test
    public void testSubmitInvalidForm() throws Exception {
        // Arrange
        String task = "";

        // Act
        mockMvc.perform(post("/todos/create")
                    .param("task", task))
                // Assert
                .andExpect(status().isOk())
                .andExpect(model().attributeHasFieldErrors("todo", "task"))
                .andExpect(view().name("all-todos.jsp"));
    }

    @Test
    public void testToggleTodo() throws Exception {
        // Arrange
        long id = 1L;
        boolean isComplete = true;

        // Act
        mockMvc.perform(post("/todos/" + id + "/toggle")
                        .param("id", String.valueOf(id))
                        .param("isComplete", String.valueOf(isComplete)))
                // Assert
                .andExpect(status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/todos"));
    }

    @Test
    public void testDeleteTodo() throws Exception {
        long id = 1L;

        mockMvc.perform(post("/todos/" + id + "/delete")
                    .param("id", String.valueOf(id)))
                // Assert
                .andExpect(status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/todos"));
    }
}
