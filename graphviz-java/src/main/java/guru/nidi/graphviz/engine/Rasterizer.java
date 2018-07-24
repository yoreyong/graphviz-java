/*
 * Copyright © 2015 Stefan Niederhauser (nidin@gmx.ch)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package guru.nidi.graphviz.engine;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.function.Consumer;

public interface Rasterizer {
    Rasterizer BATIK = IoUtils.isOnClasspath("org.apache.batik.transcoder.Transcoder") ? new BatikRasterizer() : null;
    Rasterizer SALAMANDER = IoUtils.isOnClasspath("com.kitfox.svg.SVGDiagram") ? new SalamanderRasterizer() : null;
    Rasterizer DEFAULT = BATIK == null ? SALAMANDER : BATIK;

    Format format();

    BufferedImage rasterize(Graphviz graphviz, Consumer<Graphics2D> graphicsConfigurer, String input);
}
