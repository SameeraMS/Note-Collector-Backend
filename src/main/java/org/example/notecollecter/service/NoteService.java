package org.example.notecollecter.service;

import org.example.notecollecter.dto.impl.NoteDTO;

import java.util.List;

public interface NoteService {

    NoteDTO saveNote(NoteDTO noteDTO);
    List<NoteDTO> getAllNotes();
    NoteDTO getNote(String noteId);
    boolean deleteNote(String noteId);
    boolean updateNote(String noteId, NoteDTO noteDTO);
}
