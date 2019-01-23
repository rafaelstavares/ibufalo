/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import animal.AnimalDAO;
import animal.AnimalDAOHibernate;
import bezerro.BezerroDAO;
import bezerro.BezerroDAOHibernate;
import estado.EstadoDAO;
import estado.EstadoDAOHibernate;
import fazenda.FazendaDAO;
import fazenda.FazendaDAOHibernate;
import funcionarios.FuncionariosDAO;
import funcionarios.FuncionariosDAOHibernate;
import local.LocalDAO;
import local.LocalDAOHibernate;
import cidade.CidadeDAOHibernate;
import precocidade.PrecocidadeDAO;
import precocidade.PrecocidadeDAOHibernate;
import producao.ProducaoDAO;
import producao.ProducaoDAOHibernate;
import reproducao.ReproducaoDAO;
import reproducao.ReproducaoDAOHibernate;
import sanidade.SanidadeDAO;
import sanidade.SanidadeDAOHibernate;
import usuario.UsuarioDAO;
import usuario.UsuarioDAOHibernate;
import cidade.CidadeDAO;

/**
 *
 * @author Rafael
 */
public class DAOFactory {

    public static FazendaDAO criarfazendaDao() {
        FazendaDAOHibernate fazendaDAO = new FazendaDAOHibernate();
        fazendaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

        return fazendaDAO;
    }

    public static LocalDAO criarlocalDao() {
        LocalDAOHibernate localDAO = new LocalDAOHibernate();
        localDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

        return localDAO;
    }

    public static FuncionariosDAO criarfuncionariosDao() {
        FuncionariosDAOHibernate funcionariosDAO = new FuncionariosDAOHibernate();
        funcionariosDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

        return funcionariosDAO;
    }

    public static AnimalDAO criaranimalDao() {
        AnimalDAOHibernate animalDAO = new AnimalDAOHibernate();
        animalDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

        return animalDAO;
    }

    public static ProducaoDAO criarproducaoDao() {
        ProducaoDAOHibernate producaoDAO = new ProducaoDAOHibernate();
        producaoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

        return producaoDAO;
    }

    public static SanidadeDAO criarsanidadeDao() {
        SanidadeDAOHibernate sanidadeDAO = new SanidadeDAOHibernate();
        sanidadeDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

        return sanidadeDAO;
    }

    public static ReproducaoDAO criarReproducaoDao() {
        ReproducaoDAOHibernate reproducaoDAO = new ReproducaoDAOHibernate();
        reproducaoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

        return reproducaoDAO;
    }

    public static BezerroDAO criarBezerroDao() {
        BezerroDAOHibernate bezerroDAO = new BezerroDAOHibernate();
        bezerroDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

        return bezerroDAO;
    }

    public static PrecocidadeDAO criarPrecocidadeDao() {
        PrecocidadeDAOHibernate precocidadeDAO = new PrecocidadeDAOHibernate();
        precocidadeDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

        return precocidadeDAO;
    }

    public static UsuarioDAO criarUsuarioDao() {
        UsuarioDAOHibernate usuarioDao = new UsuarioDAOHibernate();
        usuarioDao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

        return usuarioDao;
    }

    public static EstadoDAO criarEstadoDao() {
        EstadoDAOHibernate EstadoDao = new EstadoDAOHibernate();
        EstadoDao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

        return EstadoDao;
    }
    public static CidadeDAO criarCidadeDao() {
        CidadeDAOHibernate cidadeDao = new CidadeDAOHibernate();
        cidadeDao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

        return cidadeDao;
    }
}
