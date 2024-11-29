package br.group.backendmarmitas.entities;

public enum UserRole {
    admin("admin"),
    user("user");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
