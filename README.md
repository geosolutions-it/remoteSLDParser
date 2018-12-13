Simple style parsing example, picks a list of styles from a remote location, using a GetStyles request,
parses it via GeoTools, and dumps on the console a few facts about them.

Sample output:

````
--- Found style wind-wb-arrows-lod ---
Style has 1 feature type style
  FeatureTypeStyle 1
    [ lod = 0 ]
      PointSymbolizerImpl
    [ in([lod], [0], [1]) = true ]
      PointSymbolizerImpl
    [ in([lod], [0], [1]) = true ]
      PointSymbolizerImpl
    [ in([lod], [0], [1]) = true ]
      PointSymbolizerImpl
    [ in([lod], [0], [1], [2], [3]) = true ]
      PointSymbolizerImpl


--- Found style wind-arrows-lod-text ---
Style has 1 feature type style
  FeatureTypeStyle 1
    [ lod = 0 ]
      PointSymbolizerImpl
      TextSymbolizerImpl
    [[ lod = 1 ] OR [ lod = 0 ]]
      PointSymbolizerImpl
      TextSymbolizerImpl
    [[ lod = 1 ] OR [ lod = 0 ] OR [ lod = 2 ]]
      PointSymbolizerImpl
      TextSymbolizerImpl
    Filter.INCLUDE
      PointSymbolizerImpl
      TextSymbolizerImpl


--- Found style wind-arrows-lod ---
Style has 1 feature type style
  FeatureTypeStyle 1
    [ lod = 0 ]
      PointSymbolizerImpl
    [[ lod = 1 ] OR [ lod = 0 ]]
      PointSymbolizerImpl
    [[ lod = 1 ] OR [ lod = 0 ] OR [ lod = 2 ]]
      PointSymbolizerImpl
    Filter.INCLUDE
      PointSymbolizerImpl
````