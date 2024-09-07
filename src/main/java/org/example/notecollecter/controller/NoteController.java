package org.example.notecollecter.controller;

import org.example.notecollecter.dto.impl.NoteDTO;
import org.example.notecollecter.util.AppUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/notes")
public class NoteController {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveNote(@RequestBody NoteDTO noteDTO) {
        noteDTO.setNoteId(AppUtil.generateNoteId());
        return "note saved successfully";
    }

    public String getSelectedNote() {
        return null;
    }

    public List<NoteDTO> getAllNotes() {
        return null;
    }

    public void deleteNote() {

    }

    public void updateNote(String noteId, NoteDTO noteDTO) {

    }

}