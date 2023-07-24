package pd.example.demo.major.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pd.example.demo.major.project.model.Profile;
import pd.example.demo.major.project.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private ProfileRepository profileRepository;


    @Override
    public void register( Profile profile) {
        profileRepository.save(profile);

    }

    @Override
    public void deleteCandidate(Long profileId) {
        profileRepository.deleteByprofileId(profileId);
    }



    @Override
    public void updateCandidate(Long profileId, Profile profile) {

        profileRepository.findByProfileId(profileId);
        profile.setName(profile.getName());

        profileRepository.save(profile);
    }
    public Profile getData(String id){
        return profileRepository.findAll().stream().filter(profile->profile.getId().equals(id)).findFirst().get();
    }



    public void save(Profile profile) {
        profileRepository.save(profile);
    }
}
