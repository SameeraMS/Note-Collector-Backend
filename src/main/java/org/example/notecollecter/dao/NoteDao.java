package org.example.notecollecter.dao;

import org.example.notecollecter.entity.impl.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteDao extends JpaRepository<NoteEntity, String> {
}
