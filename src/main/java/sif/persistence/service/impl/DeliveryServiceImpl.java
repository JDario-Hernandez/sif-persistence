package sif.persistence.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sif.persistence.dto.DeliveryDTO;
import sif.persistence.entity.Delivery;
import sif.persistence.repository.DeliveryRepository;
import sif.persistence.service.DeliveryService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;

    @Override
    public DeliveryDTO create(DeliveryDTO dto) {
        Delivery delivery = toEntity(dto);
        return toDTO(deliveryRepository.save(delivery));
    }

    @Override
    public DeliveryDTO getById(Long id) {
        return deliveryRepository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public List<DeliveryDTO> getAll() {
        return deliveryRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DeliveryDTO update(Long id, DeliveryDTO dto) {
        Optional<Delivery> optional = deliveryRepository.findById(id);
        if (optional.isPresent()) {
            Delivery delivery = toEntity(dto);
            delivery.setId(id);
            return toDTO(deliveryRepository.save(delivery));
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        deliveryRepository.deleteById(id);
    }

    private DeliveryDTO toDTO(Delivery delivery) {
        DeliveryDTO dto = new DeliveryDTO();
        dto.setId(delivery.getId());
        dto.setAddressingId(delivery.getAddressingId());
        dto.setCodSerTecEntregado(delivery.getCodSerTecEntregado());
        dto.setCantTotEntregada(delivery.getCantTotEntregada());
        dto.setEntTotal(delivery.getEntTotal());
        dto.setCausaNoEntrega(delivery.getCausaNoEntrega());
        dto.setFecEntrega(delivery.getFecEntrega());
        dto.setNoLote(delivery.getNoLote());
        dto.setTipoIdRecibe(delivery.getTipoIdRecibe());
        dto.setNoIdRecibe(delivery.getNoIdRecibe());
        dto.setEstEntrega(delivery.getEstEntrega());
        dto.setFecAnulacion(delivery.getFecAnulacion());
        dto.setCodigosEntrega(delivery.getCodigosEntrega());
        return dto;
    }

    private Delivery toEntity(DeliveryDTO dto) {
        Delivery entity = new Delivery();
        entity.setId(dto.getId());
        entity.setAddressingId(dto.getAddressingId());
        entity.setCodSerTecEntregado(dto.getCodSerTecEntregado());
        entity.setCantTotEntregada(dto.getCantTotEntregada());
        entity.setEntTotal(dto.getEntTotal());
        entity.setCausaNoEntrega(dto.getCausaNoEntrega());
        entity.setFecEntrega(dto.getFecEntrega());
        entity.setNoLote(dto.getNoLote());
        entity.setTipoIdRecibe(dto.getTipoIdRecibe());
        entity.setNoIdRecibe(dto.getNoIdRecibe());
        entity.setEstEntrega(dto.getEstEntrega());
        entity.setFecAnulacion(dto.getFecAnulacion());
        entity.setCodigosEntrega(dto.getCodigosEntrega());
        return entity;
    }
}
