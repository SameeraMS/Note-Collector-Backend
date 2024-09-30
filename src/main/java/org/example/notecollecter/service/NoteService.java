package org.example.notecollecter.service;

import org.example.notecollecter.dto.NoteStatus;
import org.example.notecollecter.dto.impl.NoteDTO;

import java.util.List;

public interface NoteService {

    void saveNote(NoteDTO noteDTO);
    NoteStatus getSelectedNote(String noteId);
    List<NoteDTO> getAllNotes();
    void deleteNote(String noteId);
    void updateNote(String noteId, NoteDTO noteDTO);
}
