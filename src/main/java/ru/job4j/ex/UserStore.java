package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User result  = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(login)) {
                result = users[i];
            }
        }
        if (result == null) {
            throw new UserNotFoundException("User not found");
        }
        return result;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean result = false;
        if (user.isValid() && user.getUsername().length() >= 3) {
            result = true;
        }
        if (!result) {
            throw new UserInvalidException("User not valid");
        }
        return result;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException en) {
            en.printStackTrace();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }

    }
}
