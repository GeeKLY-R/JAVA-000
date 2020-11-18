public interface UserDao {

    void save(User user);

    void update(User user);

    User selectOneById(Long id);

    void deleteById(Long id);
}