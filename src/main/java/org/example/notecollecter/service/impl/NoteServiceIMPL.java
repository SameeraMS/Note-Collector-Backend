package org.example.notecollecter.service.impl;

import org.example.notecollecter.dao.NoteDao;
import org.example.notecollecter.dto.impl.NoteDTO;
import org.example.notecollecter.entity.impl.NoteEntity;
import org.example.notecollecter.service.NoteService;
import org.example.notecollecter.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceIMPL implements NoteService {
    @Autowired
    private NoteDao noteDao;
    @Autowired
    private Mapping mapping;

    @Override
    public NoteDTO saveNote(NoteDTO noteDTO) {
        return mapping.toNoteDTO(noteDao.save(mapping.toNoteEntity(noteDTO)));
    }

    @Override
    public NoteDTO getSelectedNote(String noteId) {
        NoteEntity note = noteDao.getReferenceById(noteId);
        return mapping.toNoteDTO(note);
    }

    @Override
    public List<NoteDTO> getAllNotes() {
        return mapping.toNoteDTOs(noteDao.findAll());
    }

    @Override
    public void deleteNote(String noteId) {
        noteDao.deleteById(noteId);
    }

    @Override
    public void updateNote(String noteId, NoteDTO noteDTO) {
        Optional<NoteEntity> search = noteDao.findById(noteId);
        if (search.isPresent()) {
            search.get().setNoteTitle(noteDTO.getNoteTitle());
            search.get().setNoteDesc(noteDTO.getNoteDesc());
            search.get().setCreatedDate(noteDTO.getCreatedDate());
            search.get().setPriorityLevel(noteDTO.getPriorityLevel());
           // search.get().setUser();
        }
    }
}
