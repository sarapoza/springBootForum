package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

//	Como Nome está dentro de Curso, e curso é uma entidade dentro de Topico, podemos acessar o valor passando o caminho Curso e depois nome de dentro do topico. Por isso CursoNome
	Page<Topico> findByCursoNome(String nomeCurso, Pageable paginacao);

}
