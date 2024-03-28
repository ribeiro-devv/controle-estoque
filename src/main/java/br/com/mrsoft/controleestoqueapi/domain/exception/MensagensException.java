package br.com.mrsoft.controleestoqueapi.domain.exception;

public class MensagensException {

    private static final String MSG_EM_USO= " não pode ser removidO, pois está em uso!";
    private static final String MSG_NAO_ENCONTRADA = "Não existe um cadastro de ";
    public static final String MSG_USUARIO_NAO_ENCONTRADA = MSG_NAO_ENCONTRADA + "usuario com o codigo %d.";
    public static final String MSG_USUARIO_EM_USO = "Usuário de código %d " + MSG_EM_USO;
    private static final String MSG_GRUPO_EM_USO = "Grupo de código "+ MSG_EM_USO;
}
