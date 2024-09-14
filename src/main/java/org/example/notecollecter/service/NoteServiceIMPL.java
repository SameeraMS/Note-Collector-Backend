package org.example.notecollecter.service;

import org.example.notecollecter.dto.impl.NoteDTO;
import org.example.notecollecter.util.AppUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class NoteServiceIMPL implements NoteService {
    private static List<NoteDTO> noteDTOList = new ArrayList<>();

    NoteServiceIMPL() {
        noteDTOList.add(new NoteDTO("NOTE-1", "Title-1", "Description-1", "2022-01-01", "HIGH", "USER-1"));
        noteDTOList.add(new NoteDTO("NOTE-2", "Title-2", "Description-2", "2022-01-02", "MEDIUM", "USER-2"));
        noteDTOList.add(new NoteDTO("NOTE-3", "Title-3", "Description-3", "2022-01-03", "LOW", "USER-3"));
        noteDTOList.add(new NoteDTO("NOTE-4", "Title-4", "Description-4", "2022-01-04", "HIGH", "USER-4"));
    }
    @Override
    public NoteDTO saveNote(NoteDTO noteDTO) {
        noteDTO.setNoteId(AppUtil.generateNoteId());
        noteDTOList.add(noteDTO);
        return noteDTO;
    }

    @Override
    public List<NoteDTO> getAllNotes() {
        return noteDTOList;
    }

    @Override
    public NoteDTO getNote(String noteId) {
        return null;
    }

    @Override
    public boolean deleteNote(String noteId) {
        return false;
    }

    @Override
    public boolean updateNote(String noteId, NoteDTO noteDTO) {
        return false;
    }
}
