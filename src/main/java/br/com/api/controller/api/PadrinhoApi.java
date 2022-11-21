package br.com.api.controller.api;

import br.com.api.dto.ClienteDTO;
import br.com.api.dto.EventoManualDTO;
import br.com.api.dto.PadrinhoSaldoDTO;
import br.com.api.dto.PromoCodeDTO;
import br.com.api.dto.RetornoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Tag(name = "Padrinho", description = "Endpoints do padrinho.")
@ApiResponse(responseCode = "500", description = "Internal Error.")
public interface PadrinhoApi {

    @Operation(summary = "Consulta Saldo", description = "Endpoint para consultar saldo, com sucesso, retorna o saldo do padrinho.",
        tags = {"Padrinho" }, responses = {@ApiResponse(description = "Success", responseCode = "200",
        content = @Content(schema = @Schema(implementation = PadrinhoSaldoDTO.class))),

        @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
        @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
        @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
        @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content), })
    PadrinhoSaldoDTO consultaSaldo(String token, String uidApp, String idCliente);


    @Operation(summary = "Consulta Detalhada", description = "Endpoint para consultar detalhes, com sucesso, retorna lista de promocodes.",
        tags = {"Padrinho" }, responses = {@ApiResponse(description = "Success", responseCode = "200",
        content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PromoCodeDTO.class)))}),

        @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
        @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
        @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
        @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content), })
    List<PromoCodeDTO> consultaDetalhada(String token, String uidApp, String idCliente, String dataInicio, String dataFim, ClienteDTO clientePadrinhoDTO);


    @Operation(summary = "Cria PromoCode", description = "Endpoint para criar promocode, com sucesso, retorna promocodes.",
        tags = {"Padrinho" }, responses = {@ApiResponse(description = "Created", responseCode = "201",
        content = @Content(schema = @Schema(implementation = PromoCodeDTO.class))),

        @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
        @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
        @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
        @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content), })
    PromoCodeDTO criaPromoCode(String token, String uidApp, String idCliente, String produtoId);


    @Operation(summary = "Cria Evento Manual", description = "Endpoint para criar evento manual, com sucesso, retorna ok.",
        tags = {"Padrinho" }, responses = {@ApiResponse(description = "Created", responseCode = "201",
        content = @Content(schema = @Schema(implementation = RetornoDTO.class))),

        @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
        @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
        @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
        @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content), })
    RetornoDTO criaEventoManual(String token, String uidApp, String idCliente, EventoManualDTO eventoManualDTO);

}
