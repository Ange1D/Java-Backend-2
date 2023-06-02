package org.bedu.jpa.service;

import org.bedu.jpa.dto.AuthorDTO;
import org.bedu.jpa.dto.CreateAuthorDTO;

import java.util.List;

public interface IAuthorService {

    List<AuthorDTO> findAll();

    // AuthorDTO findById(long id);

    AuthorDTO save(CreateAuthorDTO data);
}
