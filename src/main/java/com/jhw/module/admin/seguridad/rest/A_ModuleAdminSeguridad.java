/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.admin.seguridad.rest;

import com.jhw.module.admin.seguridad.core.module.SeguridadCoreModule;
import com.jhw.module.admin.seguridad.core.usecase_def.ClienteUseCase;
import com.jhw.module.admin.seguridad.core.usecase_def.GrantTypeUseCase;
import com.jhw.module.admin.seguridad.service.ResourceServiceServerImplementation;
import org.springframework.stereotype.Component;
import com.jhw.module.admin.seguridad.core.usecase_def.RolUseCase;
import com.jhw.module.admin.seguridad.core.usecase_def.UsuarioUseCase;
import com.jhw.module.admin.seguridad.core.usecase_impl.init.ClienteInitializer;
import com.jhw.module.admin.seguridad.core.usecase_impl.init.UsuarioInitializer;
import com.jhw.module.admin.seguridad.service.ResourceServiceImplementation;
import com.jhw.module.admin.seguridad.service.UserResolverServiceImplementation;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Component
public class A_ModuleAdminSeguridad {

    public static final String BASE_PACKAGE = "com.jhw.module.admin.seguridad";

    public final static UsuarioUseCase usuarioUC;
    public final static RolUseCase rolUC;
    public final static ClienteUseCase clienteUC;

    static {
        ResourceServiceServerImplementation.init();
        UserResolverServiceImplementation.init();
        ResourceServiceImplementation.init();

        SeguridadCoreModule.init();

        usuarioUC = SeguridadCoreModule.getInstance().getImplementation(UsuarioUseCase.class);
        rolUC = SeguridadCoreModule.getInstance().getImplementation(RolUseCase.class);
        clienteUC = SeguridadCoreModule.getInstance().getImplementation(ClienteUseCase.class);

        UsuarioInitializer.init(usuarioUC, rolUC);
        ClienteInitializer.init(clienteUC, SeguridadCoreModule.getInstance().getImplementation(GrantTypeUseCase.class));
    }
}
