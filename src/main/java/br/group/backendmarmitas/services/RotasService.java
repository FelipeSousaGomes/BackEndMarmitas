package br.group.backendmarmitas.services;

import br.group.backendmarmitas.entities.dto.EnvioRotasDto;
import br.group.backendmarmitas.entities.dto.ReceberRotasDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import br.group.backendmarmitas.entities.dto.EnderecoDTO;
import java.util.ArrayList;
import java.util.List;


@Service
public class RotasService {

    @Autowired
    private EnderecoService enderecoService;
    public EnvioRotasDto enviarRotas(ReceberRotasDto receberRotasDto) {


        String url = "https://apirotas.tigasolutions.com.br/api/rotas/";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ReceberRotasDto> request = new HttpEntity<>(receberRotasDto, headers);
        EnvioRotasDto response = restTemplate.postForObject(url, request, EnvioRotasDto.class);
        return response;
    }



}
