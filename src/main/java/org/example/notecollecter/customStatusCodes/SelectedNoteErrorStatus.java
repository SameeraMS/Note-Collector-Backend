package org.example.notecollecter.customStatusCodes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.notecollecter.dto.NoteStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedNoteErrorStatus implements NoteStatus {
    private int statusCode;
    private String statusMessage;
}
