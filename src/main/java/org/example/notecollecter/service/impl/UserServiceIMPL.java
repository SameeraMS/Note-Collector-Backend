package org.example.notecollecter.service.impl;

import org.example.notecollecter.customStatusCodes.SelectedUserErrorStatus;
import org.example.notecollecter.dao.UserDao;
import org.example.notecollecter.dto.UserStatus;
import org.example.notecollecter.dto.impl.UserDTO;
import org.example.notecollecter.entity.impl.UserEntity;
import org.example.notecollecter.exception.DataPersistException;
import org.example.notecollecter.service.UserService;
import org.example.notecollecter.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceIMPL implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveUser(UserDTO userDTO) {
        UserEntity savedUser = userDao.save(mapping.toUserEntity(userDTO));
        if (savedUser == null) {
            throw new DataPersistException("User not saved");
        }
    }

    @Override
    public UserStatus getSelectedUser(String userId) {
        if (userDao.existsById(userId)) {
            UserEntity user = userDao.getReferenceById(userId);
            return mapping.toUserDTO(user);
        } else {
            return new SelectedUserErrorStatus(2, "User " + userId + " not found");
        }
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return mapping.toUserDTOs(userDao.findAll());
    }

    @Override
    public void deleteUser(String userId) {
        userDao.deleteById(userId);
    }

    @Override
    public void updateUser(String userId, UserDTO userDTO) {
        Optional<UserEntity> search = userDao.findById(userId);
        if (search.isPresent()) {
            search.get().setEmail(userDTO.getEmail());
            search.get().setFirstName(userDTO.getFirstName());
            search.get().setLastName(userDTO.getLastName());
            search.get().setPassword(userDTO.getPassword());
            search.get().setProfilePic(userDTO.getProfilePic());
        }
    }
}
