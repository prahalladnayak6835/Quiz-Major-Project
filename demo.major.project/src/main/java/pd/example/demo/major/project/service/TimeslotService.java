package pd.example.demo.major.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pd.example.demo.major.project.repository.TimeslotRepository;
import pd.example.demo.major.project.utility.Timeslot;

import java.util.ArrayList;
import java.util.List;
@Service
public class TimeslotService {
    @Autowired
    private TimeslotRepository timeslotRepository;

    public void save(Timeslot timeslot) {
        timeslotRepository.save(timeslot);

    }

    public Object findAll() {
        return timeslotRepository.findAll();
    }

    public List<Timeslot> getDropDown() {
//        List<Timeslot> emp=new ArrayList<>();
//        timeslotRepository.save(new Timeslot("9.00-9.15"));
//        timeslotRepository.save(new Timeslot("9.30-9.45"));
//        timeslotRepository.save(new Timeslot("10.00-10.15"));
        List<Timeslot> timeslotList = timeslotRepository.findAll();
       // System.out.printf(timeslotList.get(1).getSlot());
        return timeslotList;
    }
}
