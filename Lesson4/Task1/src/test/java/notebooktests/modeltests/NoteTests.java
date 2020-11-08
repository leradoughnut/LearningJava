package notebooktests.modeltests;

import notebook.model.Note;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NoteTests {
    @Test
    void isValidName() {
        assertFalse(Note.isValidName("Ann&"));
        assertTrue(Note.isValidName("Anna-Maria"));
        assertTrue(Note.isValidName("McDonald"));
        assertTrue(Note.isValidName("L`Agnese"));
        assertTrue(Note.isValidName("Lawrence-Depp"));
        assertFalse(Note.isValidName("Roberts_A"));
    }

    @Test
    void isValidEmail() {
        assertTrue(Note.isValidEmail("valeriia.melnychuk@gmail.com"));
        assertTrue(Note.isValidEmail("lera_melnychuk@knu.ua"));
        assertFalse(Note.isValidEmail("leramelnychuk@gmail"));
    }
}
