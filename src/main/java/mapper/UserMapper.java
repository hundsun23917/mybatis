package mapper;

import bean.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    User selectUser(int id);
}
