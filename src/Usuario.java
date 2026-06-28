public class Usuario {
    protected String nome;
    protected String email;
    protected String senha;
    protected boolean admin;

    public Usuario(String nome, String email, String senha, boolean admin) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.admin = admin;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void realizarLogin() {
        System.out.printf("%s realizou login.\n", nome);
    }

    public void realizarLogoff() {
        System.out.printf("%s realizou logoff.\n", nome);
    }

    public void alterarDados(String nome, String email) {
        setNome(nome);
        setEmail(email);
        System.out.println("Dados alterados com sucesso.");
    }

    public void alterarSenha(String novaSenha) {
        this.senha = novaSenha;
        System.out.println("Senha alterada com sucesso.");
    }
}
