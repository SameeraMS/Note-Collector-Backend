package org.example.notecollecter.controller;

import jakarta.json.bind.JsonbBuilder;
import org.example.notecollecter.dto.impl.NoteDTO;
import org.example.notecollecter.service.NoteService;
import org.example.notecollecter.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteDTO saveNote(@RequestBody NoteDTO noteDTO) {
        return noteService.saveNote(noteDTO);
    }

    public String getSelectedNote() {
        return null;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NoteDTO> getAllNotes() {
        return noteService.getAllNotes();
    }

    public void deleteNote() {

    }

    public void updateNote(String noteId, NoteDTO noteDTO) {

    }

}