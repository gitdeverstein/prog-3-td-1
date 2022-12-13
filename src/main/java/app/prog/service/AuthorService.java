package app.prog.service;

import app.prog.model.AuthorEntity;
import app.prog.model.BookEntity;
import app.prog.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorService {
    private final AuthorRepository repository;

    public List<AuthorEntity> getAuthor(){ return repository.findAll();}
    public List<AuthorEntity> createAuthor(List<AuthorEntity> toCreate) {return repository.saveAll(toCreate);}

    public List<AuthorEntity> updateAuthor(List<AuthorEntity> toUpdate) {
        return repository.saveAll(toUpdate);
    }

    public AuthorEntity deleteAuthor(int AuthorEntityId) {
        Optional<AuthorEntity> optional = repository.findById(AuthorEntityId);
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return optional.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "AuthorEntity." + AuthorEntityId + " not found"
            );
        }
    }
}
