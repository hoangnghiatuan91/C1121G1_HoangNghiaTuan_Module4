package image.repository;

import image.model.ImageOfDay;

import java.util.List;

public interface ImageOfDayRepository {
    List<ImageOfDay> findAll();
    void save (ImageOfDay imageOfDay);
    ImageOfDay update (ImageOfDay imageOfDay);
    ImageOfDay like (Long id);
    ImageOfDay findById (Long id);
}
