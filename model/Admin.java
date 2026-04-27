public class Admin {
    private int adminId;
    private String username;
    private String password;

    private static int adminCount = 0;

    public Admin(int adminId, String username, String password) {
        setAdminId(adminId);
        setUsername(username);
        setPassword(password);
        adminCount++;
    }

    public static int getAdminCount() {
        return adminCount;
    }   
    
    public int getAdminId() {
        return adminId;
    }

    private void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username == null || username.isEmpty()) {
            this.username = "defaultUser";
        } else {
            this.username = username;
        }
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        if (password == null || password.isEmpty()) {
            this.password = "defaultPass";
        } else {
            this.password = password;
        }
    }

    @Override
    public String toString() {
        return "Admin [adminId=" + adminId + ", username=" + username + "]";
    }
}