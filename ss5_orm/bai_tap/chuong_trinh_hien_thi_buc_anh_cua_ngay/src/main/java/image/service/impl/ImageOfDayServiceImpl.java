package image.service.impl;

import image.model.ImageOfDay;
import image.repository.ImageOfDayRepository;
import image.service.ImageOfDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageOfDayServiceImpl implements ImageOfDayService {

    @Autowired
    ImageOfDayRepository imageOfDayRepository;

    @Override
    public List<ImageOfDay> findAll() {
        return imageOfDayRepository.findAll();
    }

    @Override
    public void save(ImageOfDay imageOfDay) {
        imageOfDayRepository.save(imageOfDay);
    }

    @Override
    public ImageOfDay update(ImageOfDay imageOfDay) {
        return imageOfDayRepository.update(imageOfDay);
    }

    @Override
    public ImageOfDay like(Long id) {
        return imageOfDayRepository.like(id);
    }

    @Override
    public ImageOfDay findById(Long id) {
        return imageOfDayRepository.findById(id);
    }
}
