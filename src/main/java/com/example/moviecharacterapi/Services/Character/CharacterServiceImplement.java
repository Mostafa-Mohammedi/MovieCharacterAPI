package com.example.moviecharacterapi.Services.Character;
import com.example.moviecharacterapi.CustomException.CharacterCustomException;
import com.example.moviecharacterapi.Models.Character;
import com.example.moviecharacterapi.Repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CharacterServiceImplement implements CharacterService{

    private final CharacterRepository characterRepository;

    public CharacterServiceImplement(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public Character findById(Integer integer) {
        return characterRepository.findById(integer).orElseThrow(() -> new CharacterCustomException(integer));
    }

    @Override
    public Collection<Character> findAll() {
        if(characterRepository.findAll().size() > 0){
            return characterRepository.findAll();
        }
        else {
            throw new CharacterCustomException();
        }
    }

    @Override
    public Character add(Character entity) {
        List<Character> listCharacter = characterRepository.findAll();
        for (Character actor: listCharacter) {
            if(!entity.getFullname().equals(actor.getFullname())){
                return  characterRepository.save(entity);
            }

        }
        throw new CharacterCustomException("actor already exist");
    }

    @Override
    public Character update(Character entity) {
        List<Character> listCharacter = characterRepository.findAll();

        for (Character actor : listCharacter) {
            if(entity.getCharacter_Id() == actor.getCharacter_Id()){
                return characterRepository.save(entity);

            }
        }
        throw new CharacterCustomException("actor doesnt exist, cannot update");
    }

    @Override
    public void deleteById(Integer integer) {
        var deleteActor = characterRepository.findById(integer).orElseThrow(()-> new CharacterCustomException(integer));
        characterRepository.deleteById(deleteActor.getCharacter_Id());
    }
}
