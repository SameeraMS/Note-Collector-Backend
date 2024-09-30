package org.example.notecollecter.service;

import org.example.notecollecter.dto.UserStatus;
import org.example.notecollecter.dto.impl.UserDTO;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);
    UserStatus getSelectedUser(String userId);
    List<UserDTO> getAllUsers();
    void deleteUser(String userId);
    void updateUser(String userId, UserDTO userDTO);
}
