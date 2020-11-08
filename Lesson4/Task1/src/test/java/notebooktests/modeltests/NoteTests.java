package notebooktests.modeltests;

import notebook.model.Note;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NoteTests {
    @Test
    void isValidFirstName() {
        assertFalse(Note.isValidFirstName("Ann&"));
        assertTrue(Note.isValidFirstName("Anna-Maria"));

    }

    @Test
    void isValidLastName() {
        assertTrue(Note.isValidLastName("McDonald"));
        assertTrue(Note.isValidLastName("L’Agnese"));
        assertTrue(Note.isValidLastName("Lawrence-Depp"));
        assertFalse(Note.isValidLastName("Roberts_A"));
    }

    @Test
    void isValidEmail() {
        assertTrue(Note.isValidEmail("valeriia.melnychuk@gmail.com"));
        assertTrue(Note.isValidEmail("lera_melnychuk@knu.ua"));
        assertFalse(Note.isValidEmail("leramelnychuk@gmail"));
    }
}
