/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.module.admin.seguridad.rest;

import com.root101.spring.server.RESTServiceTemplate;
import static com.root101.module.admin.seguridad.rest.ModuleAdminSeguridadRESTConstants.*;
import com.root101.module.admin.seguridad.core.domain.*;
import com.root101.module.admin.seguridad.core.usecase_def.*;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
@RestController
@RequestMapping(value = USUARIO_GENERAL_PATH)
public class UsuarioRESTService extends RESTServiceTemplate<UsuarioDomain> implements UsuarioUseCase {

    private final UsuarioUseCase usuarioUC = A_ModuleAdminSeguridadRESTConfig.usuarioUC;

    public UsuarioRESTService() {
        setUseCase(usuarioUC);
    }

    @Override
    @GetMapping(USUARIO_FIND_BY_USERNAME)
    public UsuarioDomain loadUserByUsername(String username) throws Exception {
        return usuarioUC.loadUserByUsername(username);
    }

}
