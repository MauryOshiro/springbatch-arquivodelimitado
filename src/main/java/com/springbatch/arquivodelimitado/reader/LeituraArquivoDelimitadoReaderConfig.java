package com.springbatch.arquivodelimitado.reader;

import java.net.MalformedURLException;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.Resource;

import com.springbatch.arquivodelimitado.dominio.Cliente;

@Configuration
public class LeituraArquivoDelimitadoReaderConfig {
	
	@Bean
	public Resource fileUrlResource() throws MalformedURLException {
		return new FileUrlResource("files/clientes.txt");
	}
	
	@Bean
	public FlatFileItemReader<Cliente> leituraArquivoDelimitadoReader(Resource arquivoClientes) {
		return new FlatFileItemReaderBuilder<Cliente>()
				.name("leituraArquivoDelimitadoReader")
				.resource(arquivoClientes)
				.delimited()
				.delimiter(";")
				.names(new String[] {"nome", "sobrenome", "idade", "email"})
				.targetType(Cliente.class)
				.build();
    }
}
