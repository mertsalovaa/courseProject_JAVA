package app.service;

import app.entities.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    List<User> getAll();

    void save(User user);

    User getById(long id);

    void deleteById(long id);

//    Page<User> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
//
//    Page<User> findUserPaginated(FindUserDTO findUserDTO, int pageNo, int pageSize, String sortField, String sortDirection);
//
//    void resetPasswordSendEmail(User user, String domain);
}
