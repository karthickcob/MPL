//
// Copyright (c) 2018 Grid Dynamics International, Inc. All Rights Reserved
// https://www.griddynamics.com
//
// Classification level: Public
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//
// $Id: $
// @Project:     MPL
// @Description: Shared Jenkins Modular Pipeline Library
//

package com.griddynamics.devops.mpl.testing

import com.lesfurets.jenkins.unit.PipelineTestHelper
import com.lesfurets.jenkins.unit.MethodSignature

@groovy.transform.InheritConstructors
class MPLTestHelper extends PipelineTestHelper {
  public getLibraryConfig() {
    gse.getConfig()
  }
  public getLibraryClassLoader() {
    gse.groovyClassLoader
  }

  void registerAllowedMethod(MethodSignature methodSignature, Closure closure) {
    if( isMethodAllowed(methodSignature.name, methodSignature.args) )
      return // Skipping methods already existing in the list
    allowedMethodCallbacks.put(methodSignature, closure)
  }
}
