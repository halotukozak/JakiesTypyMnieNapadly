package halotukozak
package live_coding

import scala.compiletime.ops.string.Matches

type HeadingLevel = 1 | 2 | 3 | 4 | 5 | 6

inline def heading[N <: HeadingLevel : ValueOf](inline inner: String): String = "#" * valueOf[N] + inner


inline def link[Title <: String & Singleton]
  (inline title: Title, inline url: String)
  (using Matches[Title, ".*MUST.*"] =:= true)
: String = s"[$title]($url)"