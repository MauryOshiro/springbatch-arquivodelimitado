package com.springbatch.arquivodelimitado.reader;

import java.lang.reflect.Field;
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
	public String[] fieldNames() {
		Field[] declaredFields = Cliente.class.getDeclaredFields();
		String[] names = new String[declaredFields.length];
		
		for(int i = 0; i < declaredFields.length; i++) {
			String name = declaredFields[i].getName();
			names[i] = name;
			
			System.out.println("Adicionado campo " + name + " na posição " + i);
		}
		
		return names;
	}
	
	@Bean
	public FlatFileItemReader<Cliente> leituraArquivoDelimitadoReader(Resource arquivoClientes,
			String[] names) {
		return new FlatFileItemReaderBuilder<Cliente>()
				.name("leituraArquivoDelimitadoReader")
				.resource(arquivoClientes)
				.delimited()
				.delimiter(";")
				.names(names)
				.targetType(Cliente.class)
				.build();
    }
}
