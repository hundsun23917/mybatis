package mapper;

import bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    User selectUser(int id);
    int insertUser(User user);
    void insertUser1(User user);

    void batchInsertUsers(List<User> list);
}
